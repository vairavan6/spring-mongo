package devactivist.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import devactivist.entity.PasFileHierarchy;

@Service
public class HierarchyClassifier {

	static String IDENTIFIER_CONST =  "->";
	static String filePath = "D:\\Workspace\\Eclipse\\spring-mongo\\src\\main\\resources\\hierarchyWorkbook.xls";

	public static void main(String[] args) {
		File workBookfile = new File(filePath);
		try {
			Workbook hierarchyBook = WorkbookFactory.create(workBookfile);
			for(Sheet fileSheet:hierarchyBook) {
				switch(fileSheet.getSheetName()) {
					case "FileList":
						getBookFile(fileSheet);
						break;
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void getBookFile(Sheet fileSheet) {
		DataFormatter formatData = new DataFormatter();

		int startRow = 2;
		int endRow = fileSheet.getLastRowNum();

		int startCol = 0;
		int endCol = 5;

		List<PasFileHierarchy> pasList = new ArrayList<>();

		for(int currRow = startRow;currRow<=endRow;currRow++) {
			PasFileHierarchy pasBuilder = PasFileHierarchy.builder().build();

			for(int curCol=startCol; curCol<=endCol; curCol++) {
				Row rowModel = fileSheet.getRow(currRow);

				String currData = formatData.formatCellValue(rowModel.getCell(curCol));

				if(StringUtils.isEmpty(currData)) {
					continue;
				}

				if(currData.equals(IDENTIFIER_CONST)) {
					String fileName = formatData.formatCellValue(rowModel.getCell(curCol+1));
					String parentName = checkAndFindParent(fileSheet, startRow, currRow-1, startCol, curCol-1);
					pasBuilder.setFileName(fileName);
					if(!StringUtils.isEmpty(parentName)) {
						pasBuilder.setChild(true);
						pasBuilder.setParentFile(parentName);
					}
					pasList.add(pasBuilder);
					break;
				}
			}
		}
		System.out.println(pasList);
		formTreeStructure(pasList);
	}

	public static String checkAndFindParent(Sheet fileSheet, int startRow, int currRow, int startCol, int childCol) {
		DataFormatter formatData = new DataFormatter();

		/*if(startRow == currRow) {
			return null;
		}*/
		String parentName = null;

		for(int row=currRow; row>=startRow; row--) {
			for(int col=childCol; col>=startCol; col--) {
				Row rowModel = fileSheet.getRow(row);
				String rowData = formatData.formatCellValue(rowModel.getCell(col));

				if(StringUtils.isEmpty(rowData)) {
					continue;
				}

				if(rowData.equals(IDENTIFIER_CONST)) {
					parentName = formatData.formatCellValue(rowModel.getCell(col+1));
					return parentName;
				}
			}
		}
		return parentName;
	}

	private static void formTreeStructure(List<PasFileHierarchy> pasList) {
		Map<String, PasFileHierarchy> fileBasedMap = new HashMap<>();
		pasList.forEach(hierarchy -> fileBasedMap.put(hierarchy.getFileName(), hierarchy));

		pasList.forEach(hierarchy -> {
			String currFileName = hierarchy.getFileName();
			String parentName = fileBasedMap.get(currFileName).getParentFile();

			if(!StringUtils.isEmpty(parentName)) {
				fileBasedMap.get(parentName).setParent(true);
				List<PasFileHierarchy> x = fileBasedMap.get(parentName).getChildEntry();
				if(CollectionUtils.isEmpty(x)) {
					x = new ArrayList<>();
				}
				x.add(fileBasedMap.get(currFileName));
				fileBasedMap.get(parentName).setChildEntry(x);

			} else {
				fileBasedMap.get(currFileName).setParent(true);
			}
		});

		List<PasFileHierarchy> formedTreeStructure = new ArrayList<>();
		
		for(Map.Entry<String, PasFileHierarchy> entry : fileBasedMap.entrySet()) {
			PasFileHierarchy mappedHierarchy = entry.getValue();
			if(mappedHierarchy.isParent() && !mappedHierarchy.isChild()) {
				formedTreeStructure.add(mappedHierarchy);	
			}
		}

		System.out.println(formedTreeStructure);
	}

}

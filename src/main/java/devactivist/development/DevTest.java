package devactivist.development;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class DevTest {

	public static void main(String[] args) {
		List<DevEntity> x = new ArrayList<DevEntity>();
		Map<String, List<DevEntity>> value = x.stream().collect(Collectors.groupingBy(DevEntity::getFileName));
		gitRepoSyncer();
	}

	public static void gitRepoSyncer() {
		CredentialsProvider cred = new UsernamePasswordCredentialsProvider("", "");
		
		try {
			Git.cloneRepository()
			.setURI("https://github.com/ForYou-Always/forYou.git")
			.setDirectory(new File("D:\\DevTools\\Vairavan\\"))
			.setCloneAllBranches(true)
			.setCredentialsProvider(cred)
			.call();
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
	}

	public Repository openJGitCookbookRepository() throws IOException {
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		return builder
				.readEnvironment() // scan environment GIT_* variables
				.findGitDir() // scan up the file system tree
				.build();
	}

}

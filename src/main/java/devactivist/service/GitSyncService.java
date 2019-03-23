package devactivist.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.eclipse.jgit.api.FetchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.MergeResult.MergeStatus;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GitSyncService {

	static String remoteRepo = "https://github.com/vairavan6/devtools.git";
	static String localRepo = "H:\\GitProjectTest\\";
	static String gitUser = "****";
	static String gitPass = "****";

	public static void main(String[] args) {
		try {
			callGit();
		} catch (GitAPIException | IOException e) {
			e.printStackTrace();
		}
	}

	public static void callGit() throws InvalidRemoteException, TransportException, GitAPIException, IOException {
		File gitFilePath = new File(localRepo+".git");
		boolean isGitExists = gitFilePath.exists();
		
		UsernamePasswordCredentialsProvider credsProvider = new UsernamePasswordCredentialsProvider(gitUser, gitPass);
		
		if(isGitExists) {
			log.info("------------------------>Git Open "+new Date().toLocaleString());
			Git localGit = Git.open(gitFilePath);
			FetchResult fResult = localGit.fetch().call();
			String fetchMessage = fResult.getMessages();
			log.info("------------------------>Git Fetch "+new Date().toLocaleString());
			PullResult pResult = localGit.pull().setCredentialsProvider(credsProvider).setTimeout(10).call();
			String pullMessage  = pResult.getFetchResult().getMessages();
			log.info("------------------------>Git Pull "+new Date().toLocaleString());
		} else {
			log.info(new Date().toLocaleString());
			Git.cloneRepository()
			.setURI(remoteRepo)
			.setDirectory(new File(localRepo))
			.call();
			log.info(new Date().toLocaleString());
		}


	}

}

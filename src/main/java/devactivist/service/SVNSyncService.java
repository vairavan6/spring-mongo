package devactivist.service;

import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

@Service
//@Slf4j
public class SVNSyncService {

	public static void main(String[] args) {
		try {
			callSVN();
		} catch (SVNException e) {
			e.printStackTrace();
		}
	}

	public static void callSVN() throws SVNException {

		/*final SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
		try {
			final SvnCheckout checkout = svnOperationFactory.createCheckout();
			checkout.setSingleTarget(SvnTarget.fromFile(new File("H:\\Locals")));
			checkout.setSource(SvnTarget.fromURL(SVNURL.parseURIEncoded("file:///H:/SVNGitTest")));
			//... other options
			checkout.run();
		} finally {
			svnOperationFactory.dispose();
		}*/

		/*String url = "http://svn.svnkit.com/repos/svnkit/trunk/doc";
		String name = "anonymous";
		String password = "anonymous";

		SVNRepository repository = null;
		repository = SVNRepositoryFactory.create( SVNURL.parseURIDecoded("file:///H:/SVNGitTest\"") );
		ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager( name , password );
		repository.setAuthenticationManager( authManager );*/


		/*SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
		SvnCheckout svnCheckout = svnOperationFactory.createCheckout();
		svnCheckout.run();*/


		/*final ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name, password);
		final SVNURL svnUrl = SVNURL.create(url.getProtocol(), name, url.getHost(), 443, url.getPath(), true);

		SVNRepository svnRepo= SVNRepositoryFactory.create(svnUrl);
		svnRepo.setAuthenticationManager(authManager);
		svnOperationFactory.setAuthenticationManager(authManager);

		SVNDirEntry entry = svnRepo.info(".", -1);
		long remoteRevision = entry.getRevision();

		if (!workingCopyDirectory.exists()) {
		    workingCopyDirectory.mkdirs();
		}

		final SvnCheckout checkout = svnOperationFactory.createCheckout();
		checkout.setSource(SvnTarget.fromURL(svnUrl));
		checkout.setSingleTarget(SvnTarget.fromFile(workingCopyDirectory));
		remoteRevision = checkout.run();*/
		
		
		SVNURL svnurl = SVNURL.parseURIDecoded("file:///H:/SVNGitTest");
		SVNRepository repository = SVNRepositoryFactory.create(svnurl);
		ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("uname", "password");
		repository.setAuthenticationManager(authManager);
		SVNClientManager ourClientManager = SVNClientManager.newInstance();
		ourClientManager.setAuthenticationManager(authManager);
		SVNUpdateClient updateClient = ourClientManager.getUpdateClient();
		updateClient.setIgnoreExternals(true);

		long latestRevision = repository.getLatestRevision();
		if (updateClient.doCheckout(svnurl, destinationDir,
		        SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY,
		                allowUnversionedObstructions) == latestRevision) {
		    ourClientManager.dispose();
		}
	}
}

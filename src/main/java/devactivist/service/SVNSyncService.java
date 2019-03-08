package devactivist.service;

import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import org.tmatesoft.svn.core.wc2.SvnCheckout;
import org.tmatesoft.svn.core.wc2.SvnOperationFactory;
import org.tmatesoft.svn.core.wc2.SvnTarget;

import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class SVNSyncService {

	public static void main(String[] args) {
		
	}
	
	public static void callSVN() throws SVNException {
		SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
		SvnCheckout svnCheckout = svnOperationFactory.createCheckout();
		svnCheckout.run();
		
		
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
	}
}

package com.gentics.cr.util;

import java.util.Hashtable;

import com.gentics.cr.rest.ContentRepository;

/**
 * {@link RepositoryFactory} provides an index over all available
 * ContentRepositories and their shortname.
 * @author bigbear3001
 *
 */
public class RepositoryFactory {

	/**
	 * Enumeration containing the values of the repository types.
	 * @author bigbear3001
	 */
	public enum RepositoryType {

		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.xml.XmlContentRepository}.
		 */
		XML,
		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.json.JSONContentRepository}.
		 */
		JSON,
		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.php.PHPContentRepository}.
		 */
		PHP,
		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.javaxml.JavaXmlContentRepository}.
		 */
		JAVAXML,
		/**
		 * TODO javadoc. Binding is missing at the moment.
		 */
		RSS,
		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.xml.MnogosearchXmlContentRepository}.
		 */
		MNOGOSEARCHXML,
		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.javabin.JavaBinContentRepository}.
		 */
		JAVABIN,
		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.velocity.VelocityContentRepository}.
		 */
		VELOCITY,
		/**
		 * RepositoryType for 
		 * {@link com.gentics.cr.rest.xml.CSSitemapContentRepository}.
		 */
		CSSITEMAP
	}
	/**
	 * private constructor to prevent instantiation.
	 */
	private RepositoryFactory() { }
	
	/**
	 * {@link Hashtable} containing the assignment of the
	 * {@link RepositoryType}s to their classes.
	 * @see #init()
	 */
	private static Hashtable<RepositoryType, Class<? extends ContentRepository>>
			classmap = null;

	/**
	 * get a {@link Hashtable} containing the assignment of
	 * {@link RepositoryType}s as strings to their implementation classe names.
	 * @return {@link Hashtable} with the implementation classe names as strings
	 */
	public static Hashtable<String, String> getStringClassMap() {
		init();
		Hashtable<String, String> result =
			new Hashtable<String, String>(classmap.size());
		for (RepositoryType type : classmap.keySet()) {
			result.put(type.name(), classmap.get(type).getName());
		}
		return result;
	}
	
	/**
	 * get a {@link Hashtable} containing the assignment of
	 * {@link RepositoryType}s to their implementation classes.
	 * @return {@link Hashtable} with the implementation classes.
	 */
	public static Hashtable<RepositoryType, Class<? extends ContentRepository>>
			getContentRepositoryMap() {
		init();
		return classmap;
	}
	
	/**
	 * initialize the HashMap containing the assignment of
	 * {@link RepositoryType}s to the specific Repository classes.
	 */
	private static synchronized void init() {
		if (classmap == null) {
			int size = RepositoryType.values().length;
			classmap = new Hashtable<RepositoryType,
					Class<? extends ContentRepository>>(size);
			//ADD DEFAULT ENTRIES
			//CLASSMAP.put(RepositoryType.JSON, com.gentics.cr.rest.json.JSONContentRepository.class);
			classmap.put(RepositoryType.PHP,
					com.gentics.cr.rest.php.PHPContentRepository.class);
			classmap.put(RepositoryType.JAVAXML,
					com.gentics.cr.rest.javaxml.JavaXmlContentRepository.class);
			classmap.put(RepositoryType.JAVABIN,
					com.gentics.cr.rest.javabin.JavaBinContentRepository.class);
			classmap.put(RepositoryType.VELOCITY, com.gentics.cr.rest.velocity
					.VelocityContentRepository.class);
			classmap.put(RepositoryType.XML,
					com.gentics.cr.rest.xml.XmlContentRepository.class);
			classmap.put(RepositoryType.CSSITEMAP,
					com.gentics.cr.rest.xml.CSSitemapContentRepository.class);
			classmap.put(RepositoryType.MNOGOSEARCHXML, com.gentics.cr.rest.xml
					.MnogosearchXmlContentRepository.class);
		
		}
	}
}

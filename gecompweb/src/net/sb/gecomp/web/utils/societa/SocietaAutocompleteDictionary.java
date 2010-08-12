package net.sb.gecomp.web.utils.societa;



public class SocietaAutocompleteDictionary {

//	protected Logger logger = Logger.getLogger(this.getClass().getName());
//
//	// list of cities.
//	private static List dictionary;
//
//	public SocietaAutocompleteDictionary() {
//		// initialize the ditionary
//		try {
//			logger.info("initializing dictionary");
//			init();
//		} catch (Exception e) {
//			logger.error("Error initializtin sorting list");
//		}
//	}
//
//	/**
//	 * Comparator utility for sorting city names.
//	 */
//	public static final Comparator LABEL_COMPARATOR = new Comparator() {
//		String s1;
//		String s2;
//
//		// compare method for city entries.
//		public int compare(Object o1, Object o2) {
//
//			if (o1 instanceof SelectItem) {
//				s1 = ((SelectItem) o1).getLabel();
//			} else {
//				s1 = o1.toString();
//			}
//
//			if (o2 instanceof SelectItem) {
//				s2 = ((SelectItem) o2).getLabel();
//			} else {
//				s2 = o2.toString();
//			}
//			// compare ingnoring case, give the user a more automated feel when typing
//			return s1.compareToIgnoreCase(s2);
//		}
//	};
//
//	/**
//	 * Gets the dictionary of cities.
//	 *
//	 * @return dictionary list in sorted by city name, ascending.
//	 */
//	public List getDictionary() {
//		return dictionary;
//	}
//
//	private void init() {
//		try {
//			dictionary = DbManagerFactory.getInstance().getSocietaDao().list();
//		} catch (GeCompOrmException e) {
//			logger.error("Error initializtin sorting list",e);
//		}
//
//	}
}

package org.sbelli.gecomp.console.societa.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//import javax.faces.event.ValueChangeEvent;
//import javax.faces.model.SelectItem;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.model.Societa;

//import com.icesoft.faces.component.selectinputtext.SelectInputText;

public class SocietaAutocompleteBean {

//	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
//	
//    // list of cities, used for auto complete list.
//    private static List dictionary;
//
//
//    // default city, no value.
//    private Societa current = new Societa();
//
//    // list of possible matches.
//    private List matchesList = new ArrayList();
//
//    /**
//     * Called when a user has modifed the SelectInputText value.  This method
//     * call causes the match list to be updated.
//     *
//     * @param event
//     */
//    public void updateList(ValueChangeEvent event) {
//
//        // get a new list of matches.
//        setMatches(event);
//
//        // Get the auto complete component from the event and assing
//        if (event.getComponent() instanceof SelectInputText) {
//            SelectInputText autoComplete =
//                    (SelectInputText) event.getComponent();
//            // if no selected item then return the previously selected item.
//            if (autoComplete.getSelectedItem() != null) {
//                current = (Societa) autoComplete.getSelectedItem().getValue();
//            }
//            // otherwise if there is a selected item get the value from the match list
//            else {
//            	Societa temp = getMatch(autoComplete.getValue().toString());
//                if (temp != null) {
//                    current = temp;
//                }
//            }
//        }
//    }
//
//    /**
//     * Gets the currently selected city.
//     *
//     * @return selected city.
//     */
//    public Societa getCurrent() {
//        return current;
//    }
//
//    /**
//     * The list of possible matches for the given SelectInputText value
//     *
//     * @return list of possible matches.
//     */
//    public List getList() {
//        return matchesList;
//    }
//
//    private Societa getMatch(String value) {
//    	Societa result = null;
//        if (matchesList != null) {
//            SelectItem si;
//            Iterator iter = matchesList.iterator();
//            while (iter.hasNext()) {
//                si = (SelectItem) iter.next();
//                if (value.equals(si.getLabel())) {
//                    result = (Societa) si.getValue();
//                }
//            }
//        }
//        return result;
//    }
//
//
//    public List getDictionary() {
//        return dictionary;
//    }
//
//    public void setDictionary(List dictionary) {
//    	SocietaAutocompleteBean.dictionary = dictionary;
//    }
//
//    /**
//     * Utility method for building the match list given the current value of the
//     * SelectInputText component.
//     *
//     * @param event
//     */
//    private void setMatches(ValueChangeEvent event) {
//
//        Object searchWord = event.getNewValue();
//        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
//        List matchList = new ArrayList(maxMatches);
//
//        try {
//
//            int insert = Collections.binarySearch(dictionary, searchWord,
//            		SocietaAutocompleteDictionary.LABEL_COMPARATOR);
//
//            // less then zero if wer have a partial match
//            if (insert < 0) {
//                insert = Math.abs(insert) - 1;
//            }
//
//            for (int i = 0; i < maxMatches; i++) {
//                // quit the match list creation if the index is larger then
//                // max entries in the dictionary if we have added maxMatches.
//                if ((insert + i) >= dictionary.size() ||
//                    i >= maxMatches) {
//                    break;
//                }
//                matchList.add(dictionary.get(insert + i));
//            }
//        } catch (Throwable e) {
//        	logger.error("Erorr finding autocomplete matches", e);
//        }
//        // assign new matchList
//        if (this.matchesList != null) {
//            this.matchesList.clear();
//            this.matchesList = null;
//        }
//        this.matchesList = matchList;
//    }
}

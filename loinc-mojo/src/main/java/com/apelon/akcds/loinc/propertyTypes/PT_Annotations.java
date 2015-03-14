/**
 * Copyright Notice
 *
 * This is a work of the U.S. Government and is not subject to copyright
 * protection in the United States. Foreign copyrights may apply.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apelon.akcds.loinc.propertyTypes;

import gov.va.oia.terminology.converters.sharedUtils.propertyTypes.BPT_Annotations;
import java.util.List;

/**
 * Fields to treat as attributes
 * @author Daniel Armbrust
 */
public class PT_Annotations extends BPT_Annotations
{
	public PT_Annotations(List<String> skipList)
	{
		super();
		super.skipList = skipList;
		
		addProperty("DT_LAST_CH", 0, 1);  //replaced with DATE_LAST_CHANGED in 2.38
		addProperty("DATE_LAST_CHANGED", 2, 0);
		addProperty("CHNG_TYPE");
		addProperty("COMMENTS");
		addProperty("ANSWERLIST", null, null, 0, 1, true);  	//deleted in 2.38
		addProperty("SCOPE", null, null, 0, 1, true);			//deleted in 2.38
		addProperty("IPCC_UNITS", null, null, 0, 1, true);	//deleted in 2.38
		addProperty("REFERENCE", 0, 1);				//deleted in 2.38
		addProperty("MOLAR_MASS");
		addProperty("CLASSTYPE");
		addProperty("FORMULA");
		addProperty("SPECIES");
		addProperty("EXMPL_ANSWERS");
		addProperty("CODE_TABLE");
		addProperty("SETROOT", 0, 1);				//deleted in 2.38
		addProperty("PANELELEMENTS", null, null, 0, 1, true);	//deleted in 2.38
		addProperty("SURVEY_QUEST_TEXT");
		addProperty("SURVEY_QUEST_SRC");
		addProperty("UNITSREQUIRED");
		addProperty("SUBMITTED_UNITS");
		addProperty("ORDER_OBS");
		addProperty("CDISC_COMMON_TESTS");
		addProperty("HL7_FIELD_SUBFIELD_ID");
		addProperty("EXTERNAL_COPYRIGHT_NOTICE");
		addProperty("EXAMPLE_UNITS");
		addProperty("INPC_PERCENTAGE", 0, 1);		//deleted in 2.38
		addProperty("HL7_V2_DATATYPE");
		addProperty("HL7_V3_DATATYPE");
		addProperty("CURATED_RANGE_AND_UNITS");
		addProperty("DOCUMENT_SECTION");
		addProperty("DEFINITION_DESCRIPTION_HELP", 0, 1);	//deleted in 2.38
		addProperty("EXAMPLE_UCUM_UNITS");
		addProperty("EXAMPLE_SI_UCUM_UNITS");
		addProperty("STATUS_REASON");
		addProperty("STATUS_TEXT");
		addProperty("CHANGE_REASON_PUBLIC");
		addProperty("COMMON_TEST_RANK");
		addProperty("COMMON_ORDER_RANK", 2, 0);			//added in 2.38
		addProperty("STATUS");
		addProperty("COMMON_SI_TEST_RANK", 3, 0);				//added in 2.40 (or maybe 2.39, 2.39 is untested - they failed to document it)
		addProperty("HL7_ATTACHMENT_STRUCTURE", 4, 0);				//added in 2.42 
		addProperty("NAACCR_ID");  //Moved from ID - turned out it wasn't unique (see loinc_num 42040-6 and 39807-3)
		
		//moved these two out of the descriptions
		addProperty("RELAT_NMS", null, null, 0, 1, true);			//deleted in 2.38
		addProperty("RELATEDNAMES2");
		
		//from multiaxial
		addProperty("SEQUENCE");
		addProperty("IMMEDIATE_PARENT");
		addProperty("PATH_TO_ROOT");
		
		//From Source_Organization
		addProperty("COPYRIGHT");
		addProperty("TERMS_OF_USE");
		addProperty("URL");
		
		//From Map_TO
		addProperty("COMMENT");
		
		//Things that used to be IDs below here
		
		addProperty("LOINC_NUM");
		
		//Abbrev Codes used by axis and class
		addProperty("ABBREVIATION");
		
		//From multi-axial class
		addProperty("CODE");
	}
}

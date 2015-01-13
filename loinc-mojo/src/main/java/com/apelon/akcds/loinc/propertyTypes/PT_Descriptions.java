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

import gov.va.oia.terminology.converters.sharedUtils.propertyTypes.BPT_Descriptions;


/**
 * Fields to treat as descriptions
 * 
 * @author Daniel Armbrust
 *
 */
public class PT_Descriptions extends BPT_Descriptions
{
	public PT_Descriptions()
	{
		super("LOINC");

		addProperty("CONSUMER_NAME", SYNONYM + 1);
		addProperty("EXACT_CMP_SY", null, null, 0, 1, false, SYNONYM + 1);		//deleted in 2.38
		addProperty("ACSSYM", SYNONYM + 1);
		addProperty("BASE_NAME", SYNONYM + 1);
		addProperty("SHORTNAME", SYNONYM);			//typically preferred synonym.
		addProperty("LONG_COMMON_NAME", FSN);		//this should be the FSN, unless missing, then work down the synonym hierarchy
		
		//from multiaxial
		addProperty("CODE_TEXT", FSN);
		
		//From Source_Organization
		addProperty("NAME");
	}
}

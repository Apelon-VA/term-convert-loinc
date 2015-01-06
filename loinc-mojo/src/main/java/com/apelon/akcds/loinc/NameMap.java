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
package com.apelon.akcds.loinc;

import gov.va.oia.terminology.converters.sharedUtils.ConsoleUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * Reads in a file where key and value simply alternate, one per line.
 * Ignores lines starting with "#".
 * 
 * Matching is case insensitive.
 * 
 * Used to read in the classMappings files.
 * 
 * @author Daniel Armbrust
 *
 */

public class NameMap
{
	private Hashtable<String, String> map_ = new Hashtable<String, String>();
	
	public NameMap(String mapFileName) throws IOException
	{
		ConsoleUtil.println("Using the class map file " + mapFileName);
		BufferedReader in = new BufferedReader(new InputStreamReader(NameMap.class.getResourceAsStream("/" + mapFileName)));
		
		String key = null;
		String value = null;
		for (String str = in.readLine(); str != null; str = in.readLine())
		{
			String temp = str.trim();
			if (temp.length() > 0 && !temp.startsWith("#"))
			{
				if (key == null)
				{
					key = temp;
				}
				else
				{
					value = temp;
				}
			}
			if (value != null)
			{
				String old = map_.put(key.toLowerCase(), value);
				if (old != null && !old.equals(value))
				{
					ConsoleUtil.printErrorln("Map file " + mapFileName + " has duplicate definition for " + key + ", but with different values!");
				}
				key = null;
				value = null;
			}
		}
		in.close();
	}
	
	public boolean hasMatch(String key)
	{
		return map_.containsKey(key.toLowerCase());
	}
	
	/**
	 * Returns the replacement value, or, if none, the value you passed in.
	 * @param key
	 * @return
	 */
	public String getMatchValue(String key)
	{
		String result = map_.get(key.toLowerCase());
		return (result == null ? key : result);
	}
}

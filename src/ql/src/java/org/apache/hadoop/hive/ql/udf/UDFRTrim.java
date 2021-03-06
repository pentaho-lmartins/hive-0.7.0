/*!
* Copyright 2010 - 2013 Pentaho Corporation.  All rights reserved.
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
*
*/

package org.apache.hadoop.hive.ql.udf;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * UDFRTrim.
 *
 */
@Description(name = "rtrim",
    value = "_FUNC_(str) - Removes the trailing space characters from str ",
    extended = "Example:\n"
    + "  > SELECT _FUNC_('facebook   ') FROM src LIMIT 1;\n" + "  'facebook'")
public class UDFRTrim extends UDF {

  Text result = new Text();

  public UDFRTrim() {
  }

  public Text evaluate(Text s) {
    if (s == null) {
      return null;
    }
    result.set(StringUtils.stripEnd(s.toString(), " "));
    return result;
  }

}

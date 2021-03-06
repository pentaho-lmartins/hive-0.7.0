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

package org.apache.hadoop.hive.ql.hooks;

import java.util.Set;

import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.security.UserGroupInformation;

/**
 * The pre execute hook interface. A list of such hooks can be configured to be
 * called after compilation and before execution.
 */
public interface PreExecute extends Hook {

  /**
   * The run command that is called just before the execution of the query.
   *
   * @param sess
   *          The session state.
   * @param inputs
   *          The set of input tables and partitions.
   * @param outputs
   *          The set of output tables, partitions, local and hdfs directories.
   * @param ugi
   *          The user group security information.
   */
  @Deprecated
  public void run(SessionState sess, Set<ReadEntity> inputs,
      Set<WriteEntity> outputs, UserGroupInformation ugi)
    throws Exception;

}

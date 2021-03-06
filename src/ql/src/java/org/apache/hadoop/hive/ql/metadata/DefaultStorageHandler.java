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

package org.apache.hadoop.hive.ql.metadata;

import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.metastore.HiveMetaHook;
import org.apache.hadoop.hive.ql.plan.TableDesc;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;

/**
 * DefaultStorageHandler is an implementation of {@link HiveStorageHandler}
 * which supplies the standard defaults for all options.  This can be useful
 * either as the base class for custom storage handlers, or as a mock in tests
 * (providing something which appears to be a non-native table with respect to
 * metadata even though its behavior is otherwise identical to a native table).
 */
public class DefaultStorageHandler implements HiveStorageHandler {
  private Configuration conf;

  @Override
  public Class<? extends InputFormat> getInputFormatClass() {
    return SequenceFileInputFormat.class;
  }

  @Override
  public Class<? extends OutputFormat> getOutputFormatClass() {
    return SequenceFileOutputFormat.class;
  }

  @Override
  public Class<? extends SerDe> getSerDeClass() {
    return LazySimpleSerDe.class;
  }

  @Override
  public HiveMetaHook getMetaHook() {
    // no hook by default
    return null;
  }

  @Override
  public void configureTableJobProperties(
    TableDesc tableDesc,
    Map<String, String> jobProperties) {
    // do nothing by default
  }

  @Override
  public Configuration getConf() {
    return conf;
  }

  @Override
  public void setConf(Configuration conf) {
    this.conf = conf;
  }
}

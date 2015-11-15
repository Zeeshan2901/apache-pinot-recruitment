/**
 * Copyright (C) 2014-2015 LinkedIn Corp. (pinot-core@linkedin.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.pinot.tools.scan.query;

import java.util.Collections;


public class AvgFunction extends AggregationFunc {

  AvgFunction(ResultTable rows, String column) {
    super(rows, column);
  }

  @Override
  public ResultTable run() {
    Double average = 0.0;
    int numRows = 0;

    for (ResultTable.Row row : _rows) {
      average += new Double(row.get(_column).toString());
      ++numRows;
    }

    average = average / numRows;
    ResultTable resultTable = new ResultTable(Collections.emptyList(), 1);
    resultTable.add(0, average);

    return resultTable;
  }
}

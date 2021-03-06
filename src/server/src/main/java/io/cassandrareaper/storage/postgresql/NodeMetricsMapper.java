/*
 *
 * Copyright 2019-2019 The Last Pickle Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.cassandrareaper.storage.postgresql;

import io.cassandrareaper.core.NodeMetrics;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public final class NodeMetricsMapper implements ResultSetMapper<NodeMetrics> {

  @Override
  public NodeMetrics map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
    return NodeMetrics.builder()
        .withNode(rs.getString("node"))
        .withCluster(rs.getString("cluster"))
        .withDatacenter(rs.getString("datacenter"))
        .withPendingCompactions(rs.getInt("pending_compactions"))
        .withHasRepairRunning(rs.getBoolean("has_repair_running"))
        .withActiveAnticompactions(rs.getInt("active_anticompactions"))
        .build();
  }
}
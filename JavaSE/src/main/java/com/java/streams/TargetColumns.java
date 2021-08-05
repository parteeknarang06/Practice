package com.java.streams;

/**
 * Use this pure-structure class to describe a subset of a given table that you
 * want to search.
 */
public class TargetColumns {

  private final String projectId;
  private final String datasetName;
  private final String tableName;
  private final String columnName;
  private final String dataType;

  public TargetColumns(String projectId, String datasetName, String tableName, String columnName, String dataType) {
    this.projectId = projectId;
    this.datasetName = datasetName;
    this.tableName = tableName;
    this.columnName = columnName;
    this.dataType = dataType;
  }

  public String getProjectId() {
    return projectId;
  }

  public String getDatasetName() {
    return datasetName;
  }

  public String getTableName() {
    return tableName;
  }

  public String getColumnName() {
    return columnName;
  }

  public String getDataType() {
    return dataType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((datasetName == null) ? 0 : datasetName.hashCode());
    result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
    result = prime * result + ((tableName == null) ? 0 : tableName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TargetColumns other = (TargetColumns) obj;
    if (datasetName == null) {
      if (other.datasetName != null)
        return false;
    } else if (!datasetName.equals(other.datasetName))
      return false;
    if (projectId == null) {
      if (other.projectId != null)
        return false;
    } else if (!projectId.equals(other.projectId))
      return false;
    if (tableName == null) {
      if (other.tableName != null)
        return false;
    } else if (!tableName.equals(other.tableName))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "TargetColumns [projectId=" + projectId + ", datasetName=" + datasetName + ", tableName=" + tableName
        + ", columnName=" + columnName + ", dataType=" + dataType + "]";
  }

}

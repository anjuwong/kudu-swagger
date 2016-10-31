package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * CellEntry
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class CellEntry   {
  private String columnName = null;

  private String dataType = null;

  private String value = null;

  public CellEntry columnName(String columnName) {
    this.columnName = columnName;
    return this;
  }

   /**
   * Column name for particular cell.
   * @return columnName
  **/
  @ApiModelProperty(value = "Column name for particular cell.")
  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public CellEntry dataType(String dataType) {
    this.dataType = dataType;
    return this;
  }

   /**
   * Data type for particular cell.
   * @return dataType
  **/
  @ApiModelProperty(value = "Data type for particular cell.")
  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public CellEntry value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Data value for given cell.
   * @return value
  **/
  @ApiModelProperty(value = "Data value for given cell.")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CellEntry cellEntry = (CellEntry) o;
    return Objects.equals(this.columnName, cellEntry.columnName) &&
        Objects.equals(this.dataType, cellEntry.dataType) &&
        Objects.equals(this.value, cellEntry.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(columnName, dataType, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CellEntry {\n");
    
    sb.append("    columnName: ").append(toIndentedString(columnName)).append("\n");
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Type;

/**
 * ColumnInfo
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class ColumnInfo   {
  private String name = null;

  private String dataType = null;

  private Boolean primaryKey = null;

  private Boolean nullable = null;

  public ColumnSchema buildKuduColumnSchema() {
    return new ColumnSchema.ColumnSchemaBuilder(name,
            Type.valueOf(dataType.toUpperCase()))
            .key(primaryKey)
            .build();
  }

  public ColumnInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Column name for a particular column.
   * @return name
  **/
  @ApiModelProperty(value = "Column name for a particular column.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ColumnInfo dataType(String dataType) {
    this.dataType = dataType;
    return this;
  }

   /**
   * Data type for a particular column.
   * @return dataType
  **/
  @ApiModelProperty(value = "Data type for a particular column.")
  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public ColumnInfo primaryKey(Boolean primaryKey) {
    this.primaryKey = primaryKey;
    return this;
  }

   /**
   * Flag indicating whether or not the column is a primary key.
   * @return primaryKey
  **/
  @ApiModelProperty(value = "Flag indicating whether or not the column is a primary key.")
  public Boolean getPrimaryKey() {
    return primaryKey;
  }

  public void setPrimaryKey(Boolean primaryKey) {
    this.primaryKey = primaryKey;
  }

  public ColumnInfo nullable(Boolean nullable) {
    this.nullable = nullable;
    return this;
  }

   /**
   * Flag indicating whether or not the column is nullable.
   * @return nullable
  **/
  @ApiModelProperty(value = "Flag indicating whether or not the column is nullable.")
  public Boolean getNullable() {
    return nullable;
  }

  public void setNullable(Boolean nullable) {
    this.nullable = nullable;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ColumnInfo columnInfo = (ColumnInfo) o;
    return Objects.equals(this.name, columnInfo.name) &&
        Objects.equals(this.dataType, columnInfo.dataType) &&
        Objects.equals(this.primaryKey, columnInfo.primaryKey) &&
        Objects.equals(this.nullable, columnInfo.nullable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, dataType, primaryKey, nullable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ColumnInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
    sb.append("    primaryKey: ").append(toIndentedString(primaryKey)).append("\n");
    sb.append("    nullable: ").append(toIndentedString(nullable)).append("\n");
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


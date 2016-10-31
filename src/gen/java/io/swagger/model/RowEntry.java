package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.RowEntry;
import io.swagger.model.CellEntry;
import java.util.ArrayList;
import java.util.List;
import org.apache.kudu.client.PartialRow;

/**
 * RowEntry
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-29T00:36:11.447Z")
public class RowEntry {

  public void getKuduRow(PartialRow row) {
    for (CellEntry cell: cells) {
      switch (cell.getDataType().toUpperCase()) {
        case "INT8":
        case "INT16":
        case "INT32":
        case "INT64":
          row.addInt(cell.getColumnName(), Integer.parseInt(cell.getValue()));
          break;
        case "FLOAT":
          row.addFloat(cell.getColumnName(), Float.parseFloat(cell.getValue()));
          break;
        case "DOUBLE":
          row.addDouble(cell.getColumnName(), Double.parseDouble(cell.getValue()));
          break;
        case "STRING":
          row.addString(cell.getColumnName(), cell.getValue());
          break;
        case "TIMESTAMP":
        case "BINARY":
        default:
          break;
      }
    }
  }

  private List<CellEntry> cells = new ArrayList<CellEntry>();

  public RowEntry cells(List<CellEntry> cells) {
    this.cells = cells;
    return this;
  }

  public RowEntry addCellsItem(CellEntry cellsItem) {
    this.cells.add(cellsItem);
    return this;
  }

   /**
   * Get cells
   * @return cells
  **/
  @ApiModelProperty(value = "")
  public List<CellEntry> getCells() {
    return cells;
  }

  public void setCells(List<CellEntry> cells) {
    this.cells = cells;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RowEntry rowEntry = (RowEntry) o;
    return Objects.equals(this.cells, rowEntry.cells);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cells);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RowEntry {\n");
    
    sb.append("    cells: ").append(toIndentedString(cells)).append("\n");
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


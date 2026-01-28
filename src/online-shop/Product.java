import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Product {
  int id;
  String name; // max 20 chars
  String supplier; // max 100 chars
  double price;
  int stock;

  public Product(int id, String name, String supplier, double price, int stock) {
    this.id = id;
    this.name = name;
    this.supplier = supplier;
    this.price = price;
    this.stock = stock;
  }

  public Product() {
  }

  public void addProduct() {
    try {
      RandomAccessFile filePointer = new RandomAccessFile("product.data", "rw");
      filePointer.seek(filePointer.length());
      filePointer.writeInt(this.id);

      byte[] productName = new byte[20];
      productName = (name + " ".repeat(20)).getBytes();
      filePointer.write(productName,0, 20);

      byte[] productSupplier = new byte[100];
      productSupplier = (supplier + " ".repeat(100)).getBytes();
      filePointer.write(productSupplier, 0, 100);

      filePointer.writeDouble(price);
      filePointer.writeInt(stock);

      filePointer.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public String readProduct() {
    try {
      RandomAccessFile fpt = new RandomAccessFile("product.data", "r");
      int productId = fpt.readInt();
      byte[] productName = new byte[20];
      fpt.read(productName, 0, 20);
      byte[] productSupplier = new byte[100];
      fpt.read(productSupplier, 0, 100);
      double productPrice = fpt.readDouble();
      int productStock = fpt.readInt();

      return productId + "," + new String(productName) + "," + new String(productSupplier) + "," + productPrice + "," + productStock;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String readProduct(int recordNumber) {
    try {
      RandomAccessFile fpt = new RandomAccessFile("product.data", "r");
      fpt.seek(136 * (recordNumber - 1));
      int productId = fpt.readInt();
      byte[] productName = new byte[20];
      fpt.read(productName, 0, 20);
      byte[] productSupplier = new byte[100];
      fpt.read(productSupplier, 0, 100);
      double productPrice = fpt.readDouble();
      int productStock = fpt.readInt();

      return productId + "," + new String(productName) + "," + new String(productSupplier) + "," + productPrice + "," + productStock;
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String searchByName(String name) {
    try {
      RandomAccessFile fpt = new RandomAccessFile("product.data", "r");

      int row = 1;
      while (fpt.getFilePointer() < fpt.length()) {
        fpt.readInt();
        byte[] productName = new byte[20];
        fpt.read(productName, 0, 20);
        String pName = new String(productName).strip();
        if (pName.equals(name)) return pName + " found at row " + row;
        fpt.seek(fpt.getFilePointer() + 136 - 4 - 20);
        row++;
      }

      return name + " not found";
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void addStock(int stock) {
    this.stock += stock;
  }

  public void sell(int stock) {
    this.stock -= stock;
  }
}
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WarehouseManagementSystem {

	static class Stock {
		String productCode;
		String batchNumber;
		Date manufacturingDate;
		Date expiryDate;
		String warehouseCode;
		double quantity;

		Stock(String productCode, String batchNumber, Date manufacturingDate, Date expiryDate, String warehouseCode,
				double quantity) {
			this.productCode = productCode;
			this.batchNumber = batchNumber;
			this.manufacturingDate = manufacturingDate;
			this.expiryDate = expiryDate;
			this.warehouseCode = warehouseCode;
			this.quantity = quantity;

		}

		@Override
		public String toString() {
			return "Stock [productCode=" + productCode + ", batchNumber=" + batchNumber + ", manufacturingDate="
					+ manufacturingDate + ", expiryDate=" + expiryDate + ", warehouseCode=" + warehouseCode
					+ ", quantity=" + quantity + "]";
		}

	}

	public static void main(String[] args) {
		List<Stock> list = new ArrayList<>();

		// 5 stock information added in list
		list.add(new Stock("4070071967072", "M2109 - 7536", new Date(2014, 04, 12), new Date(2028, 05, 11), "WH101",
				15.45));
		list.add(new Stock("4070071966454", "Q2109 - 7654", new Date(2017, 03, 20), new Date(2024, 06, 07), "WH422",
				22.43));
		list.add(new Stock("4070071967645", "J2109 - 7796", new Date(2016, 11, 05), new Date(2029, 12, 15), "WH101",
				12.54));
		list.add(new Stock("4070071962766", "P2109 - 9876", new Date(2009, 12, 21), new Date(2025, 04, 04), "WH983",
				43.76));
		list.add(new Stock("4070071964576", "E2109 - 4546", new Date(2011, 07, 05), new Date(2026, 01, 19), "WH203",
				22.65));

		for (Stock st : list) {
			System.out.println(st);
		}
		
		/*
		Stock [productCode=4070071967072, batchNumber=M2109 - 7536, manufacturingDate=Tue May 12 00:00:00 IST 3914, expiryDate=Mon Jun 11 00:00:00 IST 3928, warehouseCode=WH101, quantity=15.45]
		Stock [productCode=4070071966454, batchNumber=Q2109 - 7654, manufacturingDate=Fri Apr 20 00:00:00 IST 3917, expiryDate=Mon Jul 07 00:00:00 IST 3924, warehouseCode=WH422, quantity=22.43]
		Stock [productCode=4070071967645, batchNumber=J2109 - 7796, manufacturingDate=Tue Dec 05 00:00:00 IST 3916, expiryDate=Wed Jan 15 00:00:00 IST 3930, warehouseCode=WH101, quantity=12.54]
		Stock [productCode=4070071962766, batchNumber=P2109 - 9876, manufacturingDate=Fri Jan 21 00:00:00 IST 3910, expiryDate=Mon May 04 00:00:00 IST 3925, warehouseCode=WH983, quantity=43.76]
		Stock [productCode=4070071964576, batchNumber=E2109 - 4546, manufacturingDate=Sat Aug 05 00:00:00 IST 3911, expiryDate=Fri Feb 19 00:00:00 IST 3926, warehouseCode=WH203, quantity=22.65]
		 */
		
		

	}

}

package com.example.mapping.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.example.mapping.model.User;

public class Helper {

	// check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file) {

		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}

	}

	// convert excel to list of products

	public static List<User> convertExcelToListOfUsers(InputStream is) {
		List<User> list = new ArrayList<>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(is);

			XSSFSheet sheet = workbook.getSheet("data");

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;

				User u = new User();

				while (cells.hasNext()) {
					Cell cell = cells.next();

					switch (cid) {
					case 0:
						u.setId((long) cell.getNumericCellValue());
						break;
					case 1:
						u.setFirstName(cell.getStringCellValue());
						break;
					case 2:
						u.setLastName(cell.getStringCellValue());
						break;
					case 3:
						u.setEmail(cell.getStringCellValue());
						break;
					default:
						break;
					}
					cid++;

				}

				list.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}

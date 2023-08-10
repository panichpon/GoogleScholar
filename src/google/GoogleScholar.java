package google;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import google.model.GoogleScholarCiteModel;
import google.model.GoogleScholarModel;
import google.model.GoogleScholarPubModel;

public class GoogleScholar {

	public static void main(String[] args) {

		try {

			String COMMA_DELIMITER = ",";

			List<List<String>> records = new ArrayList<>();
			try (BufferedReader bur = new BufferedReader(new FileReader("msu-it-google-scholar.csv"))) {
				String line;
				while ((line = bur.readLine()) != null) {
					System.out.println(line);
					String[] values = line.split(COMMA_DELIMITER);
					records.add(Arrays.asList(values));
				}

			}

			String no = null;
			String name = null;
			String depart = null;
			String gooscholarId = null;
			
			ArrayList<GoogleScholarModel> googleList = new ArrayList<GoogleScholarModel>();
			
			for (int r = 0; r < records.size(); r++) {
				
				GoogleScholarModel gooscholar = new GoogleScholarModel();
				
				
				no = records.get(r).get(0);
				name = records.get(r).get(1);
				depart = records.get(r).get(2);
				gooscholarId = records.get(r).get(3);
				
				gooscholar.setName(name);
				gooscholar.setDepart(depart);
				gooscholar.setGooscholarId(gooscholarId);
				
				
				if(gooscholarId.equals("-")) {
					System.out.println(no + " -> 404 -> " + name + " -> " +depart);
					googleList.add(gooscholar);
					continue;
				} else {
					System.out.println(no + " -> " + gooscholarId + " -> " + name + " -> " +depart);
				}

				

				URL url = new URL("http://localhost/googlescholar.php?user="+gooscholarId);

				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json");
				con.setRequestProperty("Accept", "application/json");
				con.setDoOutput(true);

				
				//String jsonInputString = "{\"name\": \"Upendra\", \"job\": \"Programmer\"}";
				  
				/*String jsonInputString = "{\"user\": \"yU7nwHoAAAAJ\"}";
				  
				  System.out.println("OK"); 
				  try (OutputStream os = con.getOutputStream()) {
					  byte[] input = jsonInputString.getBytes("utf-8"); os.write(input, 0, input.length); 
				}*/
				 

				Gson gson = new Gson();
				

				try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
					String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					}
					System.out.println(response.toString());

					JsonObject jobj = new Gson().fromJson(response.toString(), JsonObject.class);
					if(jobj.size() > 0) {
						int total_citations_all = jobj.get("total_citations_all").getAsInt();
						int total_citations_six_y = jobj.get("total_citations_six_y").getAsInt();
						int hindex_all = jobj.get("hindex_all").getAsInt();
						int hindex_six_y = jobj.get("hindex_six_y").getAsInt();
						int i10_index_all = jobj.get("i10_index_all").getAsInt();
						int i10_index_six_y = jobj.get("i10_index_six_y").getAsInt();
						JsonObject citations_per_year = jobj.get("citations_per_year").getAsJsonObject();
						JsonArray publications = jobj.get("publications").getAsJsonArray();
	
						gooscholar.setTotal_citations_all(total_citations_all);
						gooscholar.setTotal_citations_six_y(total_citations_six_y);
						gooscholar.setHindex_all(hindex_all);
						gooscholar.setHindex_six_y(hindex_six_y);
						gooscholar.setI10_index_all(i10_index_all);
						gooscholar.setI10_index_six_y(i10_index_six_y);
	
						GoogleScholarCiteModel citeModel = new GoogleScholarCiteModel();
						citeModel.setCite(citations_per_year.asMap());
						gooscholar.setCitations_per_year(citeModel);
	
						ArrayList<GoogleScholarPubModel> pubModelList = new ArrayList<GoogleScholarPubModel>();
						for (int i = 0; i < publications.size(); i++) {
							GoogleScholarPubModel pubModel = gson.fromJson(publications.get(i),
									GoogleScholarPubModel.class);
							pubModelList.add(pubModel);
						}
	
						gooscholar.setPublications(pubModelList);
					}

				}
				
				googleList.add(gooscholar);

			}
			
			System.out.println("-------");
			
			System.out.println("size = "+ googleList.size());
			
			for (int i = 0; i < googleList.size(); i++) {
				GoogleScholarModel gModel = googleList.get(i);
				System.out.print(gModel.getName() + "," + gModel.getDepart() + "," +gModel.getGooscholarId() + "," + gModel.getTotal_citations_all() + ",");
				
				
				if(gModel.getCitations_per_year() != null) {
				
					Map<String, JsonElement> yCite = gModel.getCitations_per_year().getCite();
					
					
					if(yCite.size() > 0) {
						for (int j = 2018; j <= 2023; j++) {
							if(yCite.containsKey(Integer.toString(j))) {
								System.out.print((j < 2023) ? yCite.get(Integer.toString(j))+"," : yCite.get(Integer.toString(j)));
							} else {
								System.out.print((j < 2023) ? "0," : "0");
							}
						}
					} 
				}
				
				if(gModel.getPublications() != null) {
					
					List<GoogleScholarPubModel> yPub = gModel.getPublications();
					
					
					if(yPub.size() > 0) {
						System.out.print(",");
						for (int j = 2018; j <= 2023; j++) {
							String year = Integer.toString(j);
							List<GoogleScholarPubModel> resultPub = yPub.stream().filter(s -> s.getYear().equalsIgnoreCase(year)).collect(Collectors.toList());
							if(resultPub.size() > 0) {
								System.out.print((j < 2023) ? resultPub.size()+"," : resultPub.size());
							} else {
								System.out.print((j < 2023) ? "0," : "0");
							}
						}
					} 
				}
				
				System.out.print("," + gModel.getHindex_all());
				
				System.out.println();
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

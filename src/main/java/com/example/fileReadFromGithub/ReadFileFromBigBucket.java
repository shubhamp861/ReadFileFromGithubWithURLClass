public class DemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);

		String stringUrl = "http://URL:PORT/rest/api/1.0/projects/TESTPRO/repos";
		String userpass = "USERNAME" + ":" + "PASSWORD";
		String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));

		URL url = new URL(stringUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();


		con.setRequestProperty("X-Requested-With", "Curl");
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		con.setRequestProperty("Authorization", basicAuth);
		con.connect();
    
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}
		br.close();
		System.out.println("" + sb.toString());
	}
}

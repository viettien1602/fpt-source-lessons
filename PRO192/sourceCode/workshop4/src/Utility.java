import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utility {

	public static String util_load_data(String path) throws IOException {
		String content = "";
		content = new String(Files.readAllBytes(Paths.get(path)));
		return content;
	}

	public static Candidate util_parse_data(String value) throws IOException {
		Candidate _obj = new Candidate();
		String data[] = value.split("\n");
		for (int i = 0; i < data.length; ++i) {
			if (data[i].split(":").length > 1) {
				String key = data[i].split(":")[0].trim();
				String key_value = data[i].split(":")[1].trim();
				_obj.set_map(key, key_value);
			}
		}
		return _obj;
	}

	public static Candidate util_add_data(String s) {
		Candidate _obj = new Candidate();
		String data[] = s.split("\n");
		for (int i = 0; i < data.length; ++i) {
			if (data[i].split(":").length == 2) {
				String key = data[i].split(":")[0].trim();
				String key_value = data[i].split(":")[1].trim();
				_obj.set_map(key, key_value);
			}
		}
		return _obj;
	}

}

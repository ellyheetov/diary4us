package org.diary4us.web.weather;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/weather")
public class weatherApi {

    String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst";
    String serviceKey = "z8IbLLe73CnG8JbkiRANq1Qw2s4SXtvesyp74f8k5aIqwqly0VOY2WtU6FqQroryVjWGvCANX0RrmYkCHhUGNA%3D%3D";

    Date d = new Date();
    SimpleDateFormat f1 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat f2 = new SimpleDateFormat("HH");


    @ApiOperation("날씨 정보 조회")
    @GetMapping("/")
    @ApiImplicitParams({
            @ApiImplicitParam(name="nx", value="위도" ),
            @ApiImplicitParam(name="ny", value="경도"),
            @ApiImplicitParam(name="numOfRows", value="한 페이지 결과 수")

    })
    public JSONObject getWether(@RequestParam(name="nx", required = true, defaultValue = "59") String nx,
                                @RequestParam(name="ny", required = true, defaultValue = "127") String ny,
                                @RequestParam(name="numOfRows", required = false, defaultValue = "10") String numOfRows
    ) throws IOException, ParseException {
        String date = f1.format(d);
        //0200 부터 2300까지 300 간격 (1일 8회)
        String time = Integer.parseInt(f2.format(d))-1+"00";

        if(Integer.parseInt(time) < 1000) time="0"+time;

        String baseDate = date;	//조회하고싶은 날짜
        String baseTime = time;	//API 제공 시간
        String type = "json";	//타입 xml, json 등등 ..

        StringBuilder urlBuilder = new StringBuilder(apiUrl);
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey);
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(nx, "UTF-8")); //경도
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(ny, "UTF-8")); //위도
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8"));  //조회하고싶은 날짜
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8"));  //조회하고싶은 시간 AM 02시부터 3시간 단위
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode(type, "UTF-8"));	 //타입
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode(numOfRows, "UTF-8"));	 //한 페이지 결과 수

        //GET방식으로 전송해서 파라미터 받아오기
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        String data= sb.toString();

        // Json parser를 만들어 만들어진 문자열 데이터를 객체화
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(data);

        return obj;
    }

}

package com.weatherootd.wootd.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherootd.wootd.dto.WeatherDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class WeatherDeserializer extends JsonDeserializer<WeatherDTO.items> {
    private final ObjectMapper objectMapper; // WeatherDTO.item을 역직렬화

    public WeatherDeserializer(ObjectMapper objectMapper) {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public WeatherDTO.items deserialize(JsonParser jp, DeserializationContext dctx) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode responseNode = node.findValue("response");

        JsonNode itemNode = responseNode.get("body").get("items").get("item");
        List<WeatherDTO.item> items = Arrays.stream(objectMapper.treeToValue(itemNode, WeatherDTO.item[].class)).
                collect(Collectors.toList());

        List<WeatherDTO.item> list = new ArrayList<>();
        for (WeatherDTO.item item : items) {
            if (item.getCategory().equals("POP")) // 강수확률
                list.add(item);
            if (item.getCategory().equals("PTY")) // 강수형태
                list.add(item);
            if (item.getCategory().equals("PCP")) // 1시간 강수량
                list.add(item);
            if (item.getCategory().equals("REH")) // 습도
                list.add(item);
            if (item.getCategory().equals("SNO")) // 1시간 신적설
                list.add(item);
            if (item.getCategory().equals("TMP")) // 1시간 기온
                list.add(item);
            if (item.getCategory().equals("TMN")) // 일 최저기온
                list.add(item);
            if (item.getCategory().equals("TMX")) // 일 최고온도
                list.add(item);
        }
        return new WeatherDTO.items(list);
    }
}

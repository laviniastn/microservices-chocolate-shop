package com.microservices.productmanagementservice.utils;

public class Utils {

    public static final String postJsonBodyProduct="{\n" +
            "        \"productName\": \"Bomboane de ciocolata\",\n" +
            "        \"productDescription\": \"ciocolata diverse sortimente\",\n" +
            "        \"productIngredients\": \"cacao, unt, zahar\",\n" +
            "        \"productPrice\": 20.5,\n" +
            "        \"productWeight\": 500.0,\n" +
            "        \"categories\": [\n" +
            "            {\n" +
            "                \"id\": 1,\n" +
            "                \"categoryName\": \"CATEGORY_BOXES\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }";

    public static final String putJsonBodyProduct="{\n" +
            "    \"id\": 2,\n" +
            "    \"productName\": \"Bomboane de ciocolata\",\n" +
            "    \"productDescription\": \"ciocolata diverse sortimente\",\n" +
            "    \"productIngredients\": \"cacao, unt, zahar\",\n" +
            "    \"productPrice\": 20.5,\n" +
            "    \"productWeight\": 500.0,\n" +
            "    \"categories\": [\n" +
            "        {\n" +
            "            \"id\": 1,\n" +
            "            \"categoryName\": \"CATEGORY_BOXES\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public static final String putJsonBodyCategory = "{\n" +
            "        \"id\": 1,\n" +
            "        \"categoryName\": \"CATEGORY_BOXES\"\n" +
            "    }";

    public static final String postJsonBodyCategory = "{\n" +
            "        \"categoryName\": \"CATEGORY_BOXES\"\n" +
            "    }";
}

package io.itsnate.wagchallenge.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StackOverflowUserFactory {

    private static StackOverflowUser convertUser(JSONObject userData) {
        try {
            JSONObject badgeCountJson = userData.getJSONObject("badge_counts");
            StackOverflowUser.BadgeCounts badgeCounts = new StackOverflowUser.BadgeCounts(
                    badgeCountJson.getInt("bronze"),
                    badgeCountJson.getInt("silver"),
                    badgeCountJson.getInt("gold")
            );
            return new StackOverflowUser(badgeCounts,
                    userData.getString("display_name"),
                    userData.getString("profile_image"));
        } catch (JSONException e) {
            e.printStackTrace();
            return new StackOverflowUser(new StackOverflowUser.BadgeCounts(0, 0, 0), "", "");
        }
    }

    public static ArrayList<StackOverflowUser> fromJson(JSONObject userListData) {
        ArrayList<StackOverflowUser> userList = new ArrayList<>();
        try {
            JSONArray arr = userListData.getJSONArray("items");
            for (int i = 0; i < arr.length(); i++) {
                userList.add(i, convertUser(arr.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userList;
    }
}


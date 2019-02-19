package org.oasystem_wanyuan.mvp.model.bean;

import java.io.Serializable;

/**
 * Created by www on 2018/12/27.
 */

public class LoginBean implements Serializable{

    /**
     * token_type : Bearer
     * expires_in : 60
     * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjU4ZjlmNzExOTA0ZWE5YmJlZDI1YWVhMzI4NmZkODc0ZWQ3NDQwYzY5MTc1ZmZlNWU3N2Q1NzExYzEwNDk5N2NmMjQwNzE3NmMwMzAwNDhkIn0.eyJhdWQiOiIzIiwianRpIjoiNThmOWY3MTE5MDRlYTliYmVkMjVhZWEzMjg2ZmQ4NzRlZDc0NDBjNjkxNzVmZmU1ZTc3ZDU3MTFjMTA0OTk3Y2YyNDA3MTc2YzAzMDA0OGQiLCJpYXQiOjE1NDU0NjM5MjgsIm5iZiI6MTU0NTQ2MzkyOCwiZXhwIjoxNTQ1NDYzOTg4LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.MOXnj-fD8vAxB7RVQAiQ-gnFi1_N4mhX_OxQFcZbiHoIadJoRGEfXOe9QqSRpDsAjKa_wVque5QPbjeOMfuk09yBE0_dH5DhfMJIqB8FhdRrREIw8tuYa477QpfU1nTP1G_IssLbcX3hKu7VzaPSQdZUNVQqD_2sN3pFwNQ6xxNWEM31UstYJyIK8hh6EdRE_rVj7kKmu7FxOGOe_JZ5YR3MJFemY-FgBVp-YHjmhcFJCz0Vlh4Z__sNe2zuvq0vfS7hUoYp6p3avExkMCTF83jAj7fWJ9ubRDkc1V3VEtgfjLO_ocHc-klywLo6aVxBRczXXFyL5FqqruceAoR2JnqYm56WwgSrT9b1-TA3XOinPLEwI4x4cSSBpZuErjvIKDZpMTexzqCW1DBdLj45t2kVCJvXSg4mN9QHIMiQdtObghlyRRRkocyjjuP1juhm0h8vYmmMrcMp3K4uyX0EONTViQWdkZHvui_c43EH2X7sIcWaHGI8TqeEI1f3xRqgV3hIDMOv07Oz6PwVk6juHhyTkS8JPVxTZTq13CCMJthDovl8NVhNWqaY6GO1_ClWvz8o4Y8gk9nNp_1BaZzbgIejhtiF8xkUw8QXxCu8ynkUC4bQv73Ntq2H-jPKvNBadacgJ68PRm4O_sYV9T1Oo80lVSuTPaQNVAbgo_ztv-0
     * refresh_token : def502002cc4de1c1c512cfe6415eac0b6fcc09604998c49ec4fee3837a316e89608d3b59837a4f0f698047455b6147505982c8d49d69acfb5864d28a0c12994c755b4b0b9d9063cf749cc642bce821a9fa0a2ab96c73ccd16d97aa2b9ec40ed072ac20918371e5b4814bb52171a826373bd55757ac51fdb50c0691d47a66ddf06766d2bbdeb4c208ddfbc43d82a18314bbb84b9bb6f06c6229c380cd2f413f0a7af09c00d08db812859a942f7ddb7c5621e0d21c71649bfc3d74366c887c30e0c55ffdd192cbf752fa517dc07a5b3d360f0eb49ec4e6b81ef7618b40abc394a234a8e0b2ca47263c55feb410c5f49d812cd10f2af41ea1c8e07ce1b18ed80c52a6fbd65397c8e3c96ae000173383c9b19f7e6719b88ca078d46e6e581ca9323670b71a658b56c69456331516f466b954afe19dcaaaf65b0da9852110ce376fc46458e9f822bf62a81128bd079020a1c501be924ce5b15ffe391016cea25927c4c
     */

    private String token_type;
    private int expires_in;
    private String access_token;
    private String refresh_token;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}

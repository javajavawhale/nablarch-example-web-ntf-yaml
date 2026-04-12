package com.nablarch.example.app.web.action;

import com.nablarch.example.app.test.http.YamlRestTest;
import com.nablarch.example.app.test.http.YamlRestTestSupport;
import nablarch.fw.web.HttpResponse;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

/**
 * {@link IndustryAction}のテストクラス
 */
@YamlRestTest
class IndustryActionTest {
    YamlRestTestSupport support;

    @Test
    void testFind() throws JSONException {
        HttpResponse response = support.sendRequest(support.get("/api/industries"));
        String message = "業種一覧取得";
        support.assertStatusCode(message, HttpResponse.Status.OK,response);
        assertEquals(message, support.readTextResource(IndustryActionTest.class, "industry-list.json")
                ,response.getBodyString(), JSONCompareMode.LENIENT);
    }
}

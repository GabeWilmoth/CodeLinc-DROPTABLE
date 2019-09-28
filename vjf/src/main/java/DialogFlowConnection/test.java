package DialogFlowConnection;

import java.io.IOException;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.cloud.dialogflow.v2.TextInput.Builder;

public class test {
	public static void main(String[] args) {
		System.out.println(getFulfil(detectIntentOld("hello")));
	}
	
	public static QueryResult detectIntentOld(String query) {
        try (SessionsClient client = SessionsClient.create()) {
            // Create the session information
            SessionName session = SessionName.of("newagent-mjmqad", "jhgfjhfjhfhk");
            
            // Set the text (hello) and language code (en-US) for the query
            Builder textInput = TextInput.newBuilder().setText(query).setLanguageCode("en-us");

            // Build the query with the TextInput
            QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

            // Performs the detect intent request
            DetectIntentResponse response = client.detectIntent(session, queryInput);

            // Display the query result
            QueryResult queryResult = response.getQueryResult();
            
            return queryResult;
        } catch (IOException ex) {
            System.out.println("Unexpcted IOException: " + ex);
            return null;
        }
    }

    public static String getFulfil(QueryResult result){
        return result.getFulfillmentText();
    }
}

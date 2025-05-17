package org.example.botreminder.deserializer;

import com.google.gson.*;
import org.example.botreminder.dto.updates.UpdateResultDto;
import org.example.botreminder.dto.updates.callback.CallbackQueryDto;
import org.example.botreminder.dto.updates.callback.CallbackQueryResultDto;
import org.example.botreminder.dto.updates.message.MessageDto;
import org.example.botreminder.dto.updates.message.MessageResultDto;

import java.lang.reflect.Type;

public class UpdateResultAdapter implements JsonDeserializer<UpdateResultDto> {

    @Override
    public UpdateResultDto deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        long updateId = jsonObject.get("update_id").getAsLong();

        if (jsonObject.has("message")) {
            MessageDto messageDto = context.deserialize(jsonObject.get("message"), MessageDto.class);
            return new MessageResultDto(updateId, messageDto);
        } else if (jsonObject.has("callback_query")) {
            CallbackQueryDto callbackQueryDto = context.deserialize(jsonObject.get("callback_query"), CallbackQueryDto.class);
            return new CallbackQueryResultDto(updateId, callbackQueryDto);
        }


        throw new JsonParseException("Update must contain either 'message' or 'callback_query'");

//        for (JsonElement jsonElement : jsonUpdate.getAsJsonArray("result")) {
//            var jsonObject = jsonElement.getAsJsonObject();
//            Class<? extends UpdateResultDto> cls = null;
//            if (jsonObject.has("message"))
//                cls = MessageResultDto.class;
//            else if (jsonObject.has("callback_query")) {
//                cls = CallbackQueryResultDto.class;
//            } else throw new JsonParseException("Could not find parsing rule for json = " + json);
//
//            var resultObject = new Gson().fromJson(jsonObject, cls);
//
//            updatesDto.getResult().add(resultObject);
//        }
    }

}

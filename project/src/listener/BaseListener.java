package listener;

import common.AppConstant;

import java.util.Map;

public abstract class BaseListener {
    protected Map<Object, Object> response;

    public void invoke() {

    }

    public Boolean isOK() {
        return response.get(AppConstant.RESPONSE_KEY.RESULT) == AppConstant.OK_RESULT;
    }
}

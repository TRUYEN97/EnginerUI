/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.Functions;

import Model.AllKeyWord;
import Model.DataSource.ModeTest.ErrorCode.ErrorCodeElement;
import Model.DataTest.DataBoxs.ItemTestData;
import Model.DataTest.ErrorLog;
import Model.DataTest.FuncAllConfig;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class AnalysisResult {

    private final ItemTestData itemTestData;
    private final FuncAllConfig allConfig;

    public AnalysisResult(ItemTestData itemTestData, FuncAllConfig allConfig) {
        this.itemTestData = itemTestData;
        this.allConfig = allConfig;
    }

    public void checkResult(boolean status, String result) {
        if (!status) {
            setFail(ErrorCodeElement.SIMPLE);
        }
        if (isResultAvailable(result) && this.allConfig.isLimitAvailable()) {
            checkResultWithLimits(result);
        } else {
            this.itemTestData.setPass(status);
        }
    }

    private boolean isResultAvailable(String result) {
        return result != null && !result.isBlank();
    }

    private void checkResultWithLimits(String StringResult) {
        switch (allConfig.getTestType()) {
            case AllKeyWord.MATCH -> {
                if (checkMatchType(StringResult)) {
                    setPass();
                } else {
                    setFail(ErrorCodeElement.SIMPLE);
                }
            }
            case AllKeyWord.LIMIT -> {
                String errorType = checkLimitType(StringResult);
                if (errorType == null) {
                    setPass();
                } else {
                    setFail(errorType);
                }
            }
            default -> {
                setFail(ErrorCodeElement.SIMPLE);
            }
        }
    }

    private void setPass() {
        this.itemTestData.clearError();
        this.itemTestData.setPass(true);
    }

    private void setFail(String errorType) {
        this.itemTestData.setErrorCode();
        this.itemTestData.setLocalErrorCode(errorType);
        this.itemTestData.setPass(false);
    }

    private boolean checkMatchType(String result) {
        try {
            if (getMatch(result, AllKeyWord.LOWER_LIMIT)) {
                return true;
            }
            return getMatch(result, AllKeyWord.UPPER_LIMIT);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLog.addError(this, e.getMessage());
            return false;
        }

    }

    private boolean getMatch(String result, String key) {
        List<String> limits = allConfig.getListSlip(key, "\\|");
        System.out.println(limits);
        if (limits != null && !limits.isEmpty()) {
            for (String spec : limits) {
                if (spec.equals(result)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private Double cvtString2Num(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String checkLimitType(String result) {
        if (isRequired(2)) {
            return null;
        }
        String upString = allConfig.getString(AllKeyWord.UPPER_LIMIT);
        String lowString = allConfig.getString(AllKeyWord.LOWER_LIMIT);
        Double upper = cvtString2Num(upString);
        Double lower = cvtString2Num(lowString);
        Double value = cvtString2Num(result);
        if ((upper == null && lower == null) || value == null) {
            return ErrorCodeElement.SIMPLE;
        }
        if (lower == null) {
            return aGreatThanB(upper, value) ? null : ErrorCodeElement.HIGH;
        } else if (upper == null) {
            return aGreatThanB(value, lower) ? null : ErrorCodeElement.LOW;
        } else {
            if (!aGreatThanB(upper, value)) {
                return ErrorCodeElement.HIGH;
            }
            if (!aGreatThanB(value, lower)) {
                return ErrorCodeElement.LOW;
            }
            return null;
        }
    }

    private boolean isRequired(int num) {
        Integer required = allConfig.getInteger(AllKeyWord.REQUIRED);
        return required != null && required == num;
    }

    private static boolean aGreatThanB(Double a, Double b) {
        return Double.max(a, b) == a;
    }
}
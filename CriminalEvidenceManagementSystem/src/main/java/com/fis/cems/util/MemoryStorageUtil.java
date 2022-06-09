package com.fis.cems.util;

import com.fis.cems.model.CriminalCase;
import com.fis.cems.model.Detective;
import com.fis.cems.model.Evidence;

import java.util.HashMap;
import java.util.Map;

public class MemoryStorageUtil {
    private static Map<Long, CriminalCase> criminalCases = new HashMap<>();

    private static Map<Long, Detective> detectives = new HashMap<>();

    private static Map<Long, Evidence> evidences = new HashMap<>();

    public static Map<Long, CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public static Map<Long, Detective> getDetectives() {
        return detectives;
    }

    public static Map<Long, Evidence> getEvidences() {
        return evidences;
    }

}

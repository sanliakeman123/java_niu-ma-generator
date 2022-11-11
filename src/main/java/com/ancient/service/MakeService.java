package com.ancient.service;

import java.io.IOException;

public interface MakeService {

    String makeFiles(String sourceUuid, String templateUuid) throws IOException, InterruptedException;

    String makeDictFile(String sourceUuid, String templateUuid) throws IOException, InterruptedException;

    String makeJoinFile(String sourceUuid, String templateUuid) throws IOException, InterruptedException;
}

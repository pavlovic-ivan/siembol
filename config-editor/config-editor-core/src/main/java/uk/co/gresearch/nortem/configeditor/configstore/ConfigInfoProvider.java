package uk.co.gresearch.nortem.configeditor.configstore;
import uk.co.gresearch.nortem.configeditor.model.ConfigEditorFile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

public interface ConfigInfoProvider {
    String RULE_COMMIT_TEMPLATE_NEW = "Adding new rule: %s";
    String RULE_COMMIT_TEMPLATE_UPDATE = "Updating rule: %s to version: %d";
    String RULE_COMMIT_TEMPLATE_RELEASE = "Rules released to version: %d";
    String CONFIG_COMMIT_TEMPLATE_NEW = "Adding new configuration: %s";
    String CONFIG_COMMIT_TEMPLATE_UPDATE = "Updating configuration: %s to version: %d";
    String CONFIG_COMMIT_TEMPLATE_RELEASE = "Configuration released to version: %d";
    String RELEASE_BRANCH_TEMPLATE = "release_%d_by_%s_on_%s";
    int MILLI_SECONDS = 1000;

    ConfigInfo getConfigInfo(String user, String config);

    ConfigInfo getReleaseInfo(String user, String release);

    int getReleaseVersion(List<ConfigEditorFile> files);

    ConfigEditorFile.ContentType getFileContentType();

    default ConfigInfo configInfoFromUser(String userName) {
        int delimiter = userName.indexOf('@');
        if (delimiter <= 0) {
            throw new IllegalArgumentException(
                    String.format("Unexpected userName format: %s", userName));
        }

        ConfigInfo ret = new ConfigInfo();
        String committer = userName.substring(0, delimiter);
        ret.setCommitter(committer);
        ret.setCommitterEmail(userName);
        return ret;
    }

    default String getLocalDateTime() {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(System.currentTimeMillis() / MILLI_SECONDS),
                TimeZone.getDefault().toZoneId())
                .toString()
                .replaceAll(":", "-");
    }

    default boolean isStoreFile(String filename) {
        return true;
    }

    default boolean isReleaseFile(String filename) {
        return true;
    }
}

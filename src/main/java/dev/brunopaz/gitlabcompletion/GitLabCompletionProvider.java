package dev.brunopaz.gitlabcompletion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

class GitLabCompletionProvider extends CompletionProvider<CompletionParameters> {

    private final String DATA_FILE = "gitlab_variables.json";

    private List<GitLabVariable> variables;

    GitLabCompletionProvider() {
        this.variables = loadVariablesData();
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet result) {

        for (GitLabVariable variable : variables) {
            result.addElement(buildCompletionItem(variable));
        }
    }

    private LookupElement buildCompletionItem(GitLabVariable variable) {
        return LookupElementBuilder.create(variable.getName()).withTypeText(variable.getVersion());
    }

    private List<GitLabVariable> loadVariablesData() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(DATA_FILE);
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

        return gson.fromJson(reader, new TypeToken<List<GitLabVariable>>(){}.getType());
    }
}
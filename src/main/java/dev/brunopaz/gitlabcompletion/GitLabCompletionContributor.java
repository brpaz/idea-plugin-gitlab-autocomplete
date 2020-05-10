package dev.brunopaz.gitlabcompletion;

import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.ElementPattern;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiFile;
import org.jetbrains.yaml.YAMLLanguage;

public class GitLabCompletionContributor extends CompletionContributor {
    private static ElementPattern<? extends PsiFile> getGitLabCIFilePattern() {
        return PlatformPatterns.psiFile().withName(".gitlab-ci.yml");
    }

    public GitLabCompletionContributor() {
        extend( CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(YAMLLanguage.INSTANCE).inFile(getGitLabCIFilePattern()),
                new GitLabCompletionProvider()
        );
    }
}

/*
 * Copyright 2012 Sergey Ignatov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.intellij.erlang;

import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.ElementDescriptionUtil;
import com.intellij.psi.PsiElement;
import com.intellij.usageView.UsageViewLongNameLocation;
import com.intellij.usageView.UsageViewNodeTextLocation;
import com.intellij.usageView.UsageViewTypeLocation;
import org.intellij.erlang.psi.ErlangFunction;
import org.intellij.erlang.psi.ErlangModule;
import org.intellij.erlang.psi.ErlangQVar;
import org.intellij.erlang.psi.ErlangRecordDefinition;
import org.jetbrains.annotations.NotNull;

/**
 * @author ignatov
 */
public class ErlangFindUsagesProvider implements FindUsagesProvider {
  @Override
  public WordsScanner getWordsScanner() {
    return null;
    // todo
    //new DefaultWordsScanner(new ErlangLexer(), TokenSet.create(ErlangTypes.ERL_ATOM, ErlangTypes.ERL_VAR), ErlangParserDefinition.COMMENTS, TokenSet.create(ErlangTypes.ERL_STRING));
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof ErlangFunction || psiElement instanceof ErlangQVar
      || psiElement instanceof ErlangRecordDefinition || psiElement instanceof ErlangModule;
  }

  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    return ElementDescriptionUtil.getElementDescription(element, UsageViewTypeLocation.INSTANCE);
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    return ElementDescriptionUtil.getElementDescription(element, UsageViewLongNameLocation.INSTANCE);
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    return ElementDescriptionUtil.getElementDescription(element, UsageViewNodeTextLocation.INSTANCE);
  }
}

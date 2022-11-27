// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.albertoventurini.graphdbplugin.language.cypher.psi.CypherTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.albertoventurini.graphdbplugin.language.cypher.psi.*;

public class CypherMapProjectionImpl extends ASTWrapperPsiElement implements CypherMapProjection {

  public CypherMapProjectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitMapProjection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CypherMapProjectionVariants> getMapProjectionVariantsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CypherMapProjectionVariants.class);
  }

  @Override
  @NotNull
  public CypherVariable getVariable() {
    return findNotNullChildByClass(CypherVariable.class);
  }

}
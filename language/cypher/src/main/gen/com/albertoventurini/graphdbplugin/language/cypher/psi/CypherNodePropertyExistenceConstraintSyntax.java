// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherNodePropertyExistenceConstraintSyntax extends PsiElement {

  @NotNull
  CypherNodeLabel getNodeLabel();

  @NotNull
  CypherPropertyExpression getPropertyExpression();

  @NotNull
  CypherVariable getVariable();

}
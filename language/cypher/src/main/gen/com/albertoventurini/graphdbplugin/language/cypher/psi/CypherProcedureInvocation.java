// This is a generated file. Not intended for manual editing.
package com.albertoventurini.graphdbplugin.language.cypher.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.albertoventurini.graphdbplugin.language.cypher.references.CypherInvocation;

public interface CypherProcedureInvocation extends CypherInvocation {

  @NotNull
  CypherProcedureArguments getProcedureArguments();

  @NotNull
  CypherProcedureInvocationBody getProcedureInvocationBody();

  String getFullName();

}
package com.snow.annotation.sunmirror;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.*;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 14-7-2.
 */
public class AssignmentAp implements AnnotationProcessor {
    private AnnotationProcessorEnvironment env;
    private AnnotationTypeDeclaration assignmentDeclaration;
    public AssignmentAp(AnnotationProcessorEnvironment env) {
        this.env = env;
        assignmentDeclaration = (AnnotationTypeDeclaration) env.getTypeDeclaration("annotation.Assignment");
    }
    @Override
    public void process() {
        Collection<Declaration> declarations = env.getDeclarationsAnnotatedWith(assignmentDeclaration);
        for (Declaration declaration : declarations) {
            processAssignmentAnnotations(declaration);
        }
    }
    private void processAssignmentAnnotations(Declaration declaration) {
        Collection<AnnotationMirror> annotations = declaration.getAnnotationMirrors();
        for (AnnotationMirror mirror : annotations) {
            if (mirror.getAnnotationType().getDeclaration().equals(assignmentDeclaration)) {
                Map<AnnotationTypeElementDeclaration, AnnotationValue> values = mirror.getElementValues();
//                String assignee = (String) getAnnotationValue(values, "assignee"); //获取注解的值
            }
        }
    }
}

package com.snow.annotation.sunmirror;

//import com.sun.mirror.apt.AnnotationProcessor;
//import com.sun.mirror.apt.AnnotationProcessorEnvironment;
//import com.sun.mirror.apt.AnnotationProcessorFactory;
//import com.sun.mirror.apt.AnnotationProcessors;
//import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Administrator on 14-7-2.
 */
public class AssignmentApf { // implements AnnotationProcessorFactory {
//    @Override
//    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds,AnnotationProcessorEnvironment env) {
//        if (atds.isEmpty()) {
//            return AnnotationProcessors.NO_OP;
//        }
//        return new AssignmentAp(env); //返回注解处理器
//    }
    public Collection<String> supportedAnnotationTypes() {
        return Collections.unmodifiableList(Arrays.asList("annotation.Assignment"));
    }

    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }
}

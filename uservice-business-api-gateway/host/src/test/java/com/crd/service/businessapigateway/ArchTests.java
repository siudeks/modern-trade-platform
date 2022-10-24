package com.crd.service.businessapigateway;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.CompositeArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

@AnalyzeClasses(packagesOf = PackageMarker.class, 
  importOptions = {ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class})
class ArchTests {

  @ArchTest
  static final ArchRule implement_general_coding_practices =
      CompositeArchRule.of(GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS)
      .and(GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS)
      .and(GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING)
      .and(GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME)
      .and(GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION)
      .because("These are Voilation of general coding rules");

  @ArchTest
  static final ArchRule noPublicConfigurations = classes()
      .that().areAnnotatedWith(Configuration.class)
      .should().notBePublic()
      .as("Configuration classes don't need to be public");

    @ArchTest
    static final ArchRule noPublicControllers = classes()
        .that().areAnnotatedWith(RestController.class)
        .should().notBePublic()
        .as("RestController classes don't need to be public");
    
}

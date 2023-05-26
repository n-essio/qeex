package io.quarkus.qeex.api.exceptions;

import io.quarkus.qeex.api.annotations.QeexConfig;
import io.quarkus.qeex.api.exceptions.QeexWebException;
import io.quarkus.qeex.api.interceptors.LanguageInterceptor;
import io.smallrye.config.SmallRyeConfig;
import org.acme.quex.enums.AcmeQeexExceptions;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.inject.spi.CDI;

public interface QeexInterface
{
   public default QeexWebException get(AcmeQeexExceptions e)
   {
      SmallRyeConfig config = ConfigProvider.getConfig().unwrap(SmallRyeConfig.class);
      var qeexConfig = config.getConfigMapping(QeexConfig.class);

      LanguageInterceptor languageInterceptor = CDI.current().select(LanguageInterceptor.class).get();

      return QeexWebException
               .builder(e.fields.projectName)
               .id(e.fields.id)
               .code(qeexConfig.get_code(e.fields.id, e.fields.code))
               .message(qeexConfig.get_message(e.fields.id, e.fields.message, languageInterceptor.getLanguage()))
               .language(qeexConfig.get_language(e.fields.id, languageInterceptor.getLanguage()));
   }
}

package eni.tp.app.eni_app.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        //SELECT pseudo, password; 1 FROM UTILISATEUR WHERE pseudo=?  AND password=?
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //1 pour indiquer que l'utilisateur est enabled
        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT email, password, 1 FROM MEMBRE WHERE email=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT MEMBRE.email, ROLES.ROLE\n" +
                "FROM MEMBRE\n" +
                "INNER JOIN ROLES ON MEMBRE.admin = ROLES.IS_ADMIN\n" +
                "WHERE MEMBRE.email = ?;");
        return jdbcUserDetailsManager;
    }

    //Mise en place des autorisations
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize


                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers("/css/**").permitAll()
                                .requestMatchers("/vendor/**").permitAll()
                                .requestMatchers("/list-movies/**").permitAll()
                                .requestMatchers("/details-movies/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .requestMatchers("/account").permitAll()
                                .requestMatchers("/creation").hasRole("ADMIN")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/admin/manage").hasRole("ADMIN")
                                .requestMatchers("/admin/add").hasRole("ADMIN")
                                .requestMatchers("/admin/delete/**").hasRole("ADMIN")
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/").permitAll()



//                        .anyRequest().authenticated()
                                .anyRequest().denyAll() //rejette
                );
        //Manière automatique de connexion par Spring
//        http.formLogin(Customizer.withDefaults());
        // ...

        //Manière Custom Connexion Spring

        //Connexion
        http.formLogin(form ->
                form.loginPage("/login")//route personnalisée définie dans DemoController
                        .defaultSuccessUrl("/")
        );

        //Déconnexion

        HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL));

        http.logout((logout)
                -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                .logoutSuccessUrl("/login?logout")
                .addLogoutHandler(clearSiteData)
        );


        return http.build();
    }
}

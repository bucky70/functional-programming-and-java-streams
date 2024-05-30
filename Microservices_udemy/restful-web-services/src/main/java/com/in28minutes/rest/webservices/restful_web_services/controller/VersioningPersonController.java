package com.in28minutes.rest.webservices.restful_web_services.controller;

import com.in28minutes.rest.webservices.restful_web_services.PersonV1;
import com.in28minutes.rest.webservices.restful_web_services.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person") //uri versioning
    public PersonV1 getFirstVersionOfPersonV1(){
        return new PersonV1("saikumar Padamati");
    }
    @GetMapping("/v2/person")
    public PersonV2 getFirstVersionOfPersonV2(){
        return new PersonV2("saikumar","Padamati");
    }

    @GetMapping(path = "/person",params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameterV1(){//request parameter versioning
        return new PersonV1("saikumar Padamati");
    }

    @GetMapping(path = "/person",params = "version=2")
    public PersonV2 getFirstVersionOfPersonRequestParameterV2(){//request parameter versioning
        return new PersonV2("saikumar"," Padamati");
    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeaderV1(){//header parameter versioning
        return new PersonV1("saikumar Padamati");
    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getFirstVersionOfPersonRequestHeaderV2(){//header parameter versioning
        return new PersonV2("saikumar"," Padamati");
    }

    @GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonContentNegotiationV1(){//content negotiation versioning
        return new PersonV1("saikumar Padamati");
    }

    @GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getFirstVersionOfPersonContentNegotiationV2(){//content negotiation versioning
        return new PersonV2("saikumar"," Padamati");
    }
}

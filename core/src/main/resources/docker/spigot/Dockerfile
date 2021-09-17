FROM ${JAVA_VERSION}

RUN curl ${SPIGOT_JAR} --output server.jar
RUN touch eula.txt
RUN echo eula=true > eula.txt

EXPOSE ${PORT}

CMD ["/bin/bash", "entrypoint.sh"]



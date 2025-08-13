FROM gradle:8.9-jdk21

WORKDIR /app

COPY . .

RUN gradle installDist

RUN mkdir -p certs \
    && [ -n "${JWT_PRIVATE_KEY:-}" ] && printf "%s" "$JWT_PRIVATE_KEY" > certs/private.pem || true \
    && [ -n "${JWT_PUBLIC_KEY:-}" ]  && printf "%s" "$JWT_PUBLIC_KEY"  > certs/public.pem  || true

CMD ./build/install/app/bin/app
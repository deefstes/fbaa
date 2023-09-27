package wiz.fbaa.branchclient.proto;

import wiz.fbaa.branchclient.grpc.Fbaa;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

public class ProtoToFile {

    public static void main (String[] args) {
        Fbaa.StreamCreatureRequest request;

        try (FileOutputStream fos = new FileOutputStream("stream_creature_request.proto")) {
            String uuid = UUID.randomUUID().toString();
            request = Fbaa.StreamCreatureRequest.newBuilder()
                    .setAvailable(true)
                    .setBranchId(uuid)
                    .addRarity(Fbaa.Rarity.RARE)
                    .addRarity(Fbaa.Rarity.COMMON)
                    .addAbility(Fbaa.SpecialAbility.ELECTRIC_DISCHARGE)
                    .addAbility(Fbaa.SpecialAbility.FIRE_BREATHING)
                    .addAbility(Fbaa.SpecialAbility.FLYING)
                    .build();

            request.writeTo(fos);

        } catch (Exception e) {}

        try (FileInputStream fos = new FileInputStream("stream_creature_request.proto")) {
            request = Fbaa.StreamCreatureRequest.newBuilder().mergeFrom(fos).build();
            System.out.println(request);

        } catch (Exception e) {
        }

    }
}

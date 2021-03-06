package org.apache.drill.exec.physical.impl;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.yammer.metrics.MetricRegistry;

import mockit.Injectable;
import mockit.NonStrictExpectations;

import org.apache.drill.common.config.DrillConfig;
import org.apache.drill.common.util.FileUtils;
import org.apache.drill.exec.expr.fn.FunctionImplementationRegistry;
import org.apache.drill.exec.memory.BufferAllocator;
import org.apache.drill.exec.ops.FragmentContext;
import org.apache.drill.exec.physical.PhysicalPlan;
import org.apache.drill.exec.physical.base.FragmentRoot;
import org.apache.drill.exec.planner.PhysicalPlanReader;
import org.apache.drill.exec.proto.CoordinationProtos;
import org.apache.drill.exec.proto.ExecProtos;
import org.apache.drill.exec.rpc.user.UserServer;
import org.apache.drill.exec.server.DrillbitContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestComparisonFunctionsNullable {
    static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TestComparisonFunctionsNullable.class);

    DrillConfig c = DrillConfig.create();
    @Test
    public void testNullableIntEqual(@Injectable final DrillbitContext bitContext,
                        @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableIntEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());

    }

    @Test
    public void testNullableBigIntEqual(@Injectable final DrillbitContext bitContext,
                                     @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableBigIntEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());

    }

    @Test
    public void testNullableIntNotEqual(@Injectable final DrillbitContext bitContext,
                                           @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableIntNotEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());

    }

    @Test
    public void testNullableBigIntNotEqual(@Injectable final DrillbitContext bitContext,
                                        @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableBigIntNotEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());

    }

    @Test
    public void testNullableIntLessThan(@Injectable final DrillbitContext bitContext,
                                           @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableIntLessThan.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(0, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @Test
    public void testNullableBigIntLessThan(@Injectable final DrillbitContext bitContext,
                                        @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableBigIntLessThan.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @Test
    public void testNullableIntLessThanEqual(@Injectable final DrillbitContext bitContext,
                                           @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableIntLessThanEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @Test
    public void testNullableBigIntLessThanEqual(@Injectable final DrillbitContext bitContext,
                                             @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableBigIntLessThanEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @Test
    public void testNullableIntGreaterThan(@Injectable final DrillbitContext bitContext,
                                                @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableIntGreaterThan.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(0, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @Test
    public void testNullableBigIntGreaterThan(@Injectable final DrillbitContext bitContext,
                                           @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableBigIntGreaterThan.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(0, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @Test
    public void testNullableIntGreaterThanEqual(@Injectable final DrillbitContext bitContext,
                                              @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableIntGreaterThanEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @Test
    public void testNullableBigIntGreaterThanEqual(@Injectable final DrillbitContext bitContext,
                                                @Injectable UserServer.UserClientConnection connection) throws Throwable{

        new NonStrictExpectations(){{
            bitContext.getMetrics(); result = new MetricRegistry("test");
            bitContext.getAllocator(); result = BufferAllocator.getAllocator(c);
        }};

        PhysicalPlanReader reader = new PhysicalPlanReader(c, c.getMapper(), CoordinationProtos.DrillbitEndpoint.getDefaultInstance());
        PhysicalPlan plan = reader.readPhysicalPlan(Files.toString(FileUtils.getResourceAsFile("/functions/nullableBigIntGreaterThanEqual.json"), Charsets.UTF_8));
        FunctionImplementationRegistry registry = new FunctionImplementationRegistry(c);
        FragmentContext context = new FragmentContext(bitContext, ExecProtos.FragmentHandle.getDefaultInstance(), connection, null, registry);
        SimpleRootExec exec = new SimpleRootExec(ImplCreator.getExec(context, (FragmentRoot) plan.getSortedOperators(false).iterator().next()));

        while(exec.next()){
            assertEquals(50, exec.getSelectionVector2().getCount());
        }

        if(context.getFailureCause() != null){
            throw context.getFailureCause();
        }

        assertTrue(!context.isFailed());
    }

    @AfterClass
    public static void tearDown() throws Exception{
      // pause to get logger to catch up.
      Thread.sleep(1000);
    }
}
